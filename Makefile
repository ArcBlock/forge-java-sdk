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
	@./gradlew test

lint:
	@echo "Linting the software..."

download-proto:
	@echo "downloading proto files"
	@echo $(shell ./download_proto.sh )



doc:
	@echo "Building the documenation..."
	@./gradlew dokka

upload-doc:
	@echo "uploading docs..."
	@aws s3 sync docs s3://docs.arcblock.io/forge/sdks/java/ --region us-west-2 --profile prod


precommit: dep lint doc build test

travis: precommit


travis-deploy:
	@echo "Deploy the software by travis"
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

.PHONY: build init travis-init install dep all test doc precommit travis clean watch run bump-version create-pr download-proto upload-doc
