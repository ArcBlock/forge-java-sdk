TOP_DIR=.
README=$(TOP_DIR)/README.md

VERSION=$(strip $(shell cat version))

build:
	@echo "Building the software..."
	@./gradlew jar


init: dep
	@echo "Initializing the repo..."
	@./gradlew build

travis-init:
	@echo "Initialize software required for travis (normally ubuntu software)"


dep:
	@echo "Install dependencies required for this repo..."
	@./gradlew buildDependents


all: build

test:
	@echo "Running test suites..."
	@./gradlew :core:test
	@./gradlew :did:test

lint:
	@echo "Linting the software..."
	@ktlint --color

download-proto:
	@echo "downloading proto files"
	@echo $(shell ./download_proto.sh )

genForgeSDK:
	@echo "generate ForgeSDK file ..."
	@./gradlew :core:genForgeSDK

del-doc-remote:
	@echo "deleting docs in docs.arcblock.io..."
	@aws s3 sync tools/ s3://docs.arcblock.io/forge/sdks/java/ --include "index.html" --region us-west-2 --profile prod

doc:
	@echo "Building the documenation..."
	@./gradlew dokka

upload-doc:
	@echo "uploading docs..."
	@aws s3 cp tools/index.html s3://docs.arcblock.io/forge/sdks/java/ --region us-west-2 --profile prod
	@aws s3 sync core/docs s3://docs.arcblock.io/forge/sdks/java/${VERSION}/ --region us-west-2 --profile prod
	@aws s3 sync core/docs s3://docs.arcblock.io/forge/sdks/java/latest/ --region us-west-2 --profile prod
	
precommit: dep build test

travis: precommit


travis-deploy:
	@echo "Deploy the software by travis"
	@./gradlew build
	@./gradlew publish

clean:
	@echo "Cleaning the build..."

watch:
	@make build
	@echo "Watching templates and slides changes..."
	@fswatch -o src/ | xargs -n1 -I{} make build

run:
	@echo "Running the software..."
	@./gradlew :examples:bootRun

include .makefiles/*.mk

.PHONY: build init travis-init install dep all test doc precommit travis clean watch run bump-version create-pr download-proto upload-doc genForgeSDK
