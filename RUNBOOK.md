# SpringBoot Collections - Operations Runbook

## CI policy
- Every PR must pass monorepo CI workflow.
- Java modules are built independently to isolate failures.
- `crud-ui` is built in CI to prevent frontend regressions.

## Release checklist
1. Merge only after CI green.
2. Tag release with affected module names.
3. Deploy modules independently (avoid cross-module blast radius).

## Rollback
- Revert the specific module commit and redeploy only that module.
- Keep previously known-good artifact per module for quick restore.
