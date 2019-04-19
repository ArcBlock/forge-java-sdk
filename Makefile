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
	@./gradlew jacocoTestReport

lint:
	@echo "Linting the software..."

doc:
	@echo "Building the documenation..."

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

include .makefiles/*.mk

.PHONY: build init travis-init install dep all test doc precommit travis clean watch run bump-version create-pr
