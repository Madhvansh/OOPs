# OOPs — Java Lab Programs

This repository contains Java lab programs for Object-Oriented Programming (Lab 1 — Lab 8).

Repository snapshot
- Current main branches: `main` (default), `copilot/add-labs-information-repository` (contains additional lab metadata)
- Top-level lab folders present in this checkout: `Lab1`, `Lab2`, `Lab3`, `Lab4`, `Lab5`, `Lab6`, `Lab7`, `Lab8`

Quick usage

1. Compile all Java files (Windows / PowerShell):

	```powershell
	Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { javac $_.FullName }
	```

2. Or compile a single file:

	```powershell
	javac Lab1\Processor.java
	java -cp Lab1 Processor
	```

Notes
- The repository was recently synced with `origin/main`. If you had local files they were preserved in the branch `local-backup` in this clone and a ZIP backup was created in the parent Downloads folder.
- .gitignore contains standard Java and IDE ignores; update it if you use a specific build tool (Maven/Gradle) and want to include `target/` or `build/` directories.

If you want, I can add a small build script or Maven/Gradle wrapper to make builds reproducible.
| `EmployeeHierarchy.java` | Employee → Manager / Intern with method overriding |
