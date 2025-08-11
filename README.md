# GFX Tool (Fabric) - Auto-build project

This repository contains a Fabric mod skeleton and a GitHub Actions workflow to build automatically.

See .github/workflows/build.yml for CI details.


Gradle Wrapper:
- This project includes `gradlew`, `gradlew.bat`, and `gradle/wrapper/gradle-wrapper.properties`.
- **Note:** `gradle/wrapper/gradle-wrapper.jar` (binary) is not included. To generate it locally, run:
    gradle wrapper --gradle-version 8.4
  This will create the jar and supporting files. Commit them to the repo so CI can use `./gradlew`.
- If you prefer not to generate the jar locally, the workflow in the separate workflow-only repo installs Gradle on CI.
