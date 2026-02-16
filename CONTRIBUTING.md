# Contributing

Thanks for your interest in contributing.

## Scope

This repository is a collection of independent examples. Keep PRs focused to one module when possible.

## Setup

- Java + Maven for backend modules
- Node.js for `crud-ui`

## PR expectations

- Include module(s) changed in PR title/description
- Add/update docs for behavior changes
- Run relevant checks before submitting

Examples:

```bash
# For a Maven module
mvn test

# For wrapper-based module
./mvnw test

# For frontend
cd crud-ui && npm test
```
