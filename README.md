# OOPs — Java Lab Programs

This repository collects Java lab assignments used in an Object-Oriented Programming course. It is organized by lab (Lab1..Lab8). The codebase contains small, self-contained exercises that demonstrate core OOP techniques: classes, encapsulation, inheritance, polymorphism, collections, file I/O, and small simulations.

This README is intentionally thorough and long: it explains the repository structure, lists the primary source files per lab (with short descriptions), provides reproducible compile/run instructions (PowerShell / Windows), explains branch and backup details, and suggests next steps for testing and CI.

Table of contents
- Repository snapshot
- Folder & file summary (per lab)
- Build & run (PowerShell)
- Quick developer tasks (format, test, run)
- Branches, backups & restore
- Contributing, style and TODOs

Repository snapshot

- Default branch: `main` (this clone tracks `origin/main`).
- Other remote branch available: `origin/copilot/add-labs-information-repository`.
- A `local-backup` branch exists in this clone containing the original un-synced files (if you previously overwrote local files during sync). A ZIP backup was also created in your Downloads folder when the repo was synced.

Top-level lab folders in this checkout

- `Lab1/` — Wallet & transaction utilities
- `Lab2/` — Amusement-park trip simulation (students, rides, teacher)
- `Lab3/` — Exam scheduling and seating (ExamCell, ExamHall, ExamCourse)
- `Lab4/` — Campus events and vibe simulation
- `Lab5/` — (may be empty or contain exercises — check the folder)
- `Lab6/` — Placement system (PSMS, Company, Student)
- `Lab7/` — (may be empty or contain exercises)
- `Lab8/` — (may be empty or contain exercises)

Files summarized by lab (short descriptions)

Note: multiple labs include a `Student` class; each `Student` is lab-scoped and lives under its lab folder. When referencing a specific `Student` type, use the folder path to avoid confusion (for example, `Lab2/Student (2).java`).

- Lab1/
	- `Processor.java` — utility methods for Wallet processing (balance calculation, token conversion, eligibility checks). Some methods are scaffolds with TODOs.
	- `Transaction.java` — transaction model: id, amount, type (credit/debit), international flag and processing fee helper.
	- `Wallet.java` — simple wallet model storing owner, bitsID, a Transaction[] history and helper methods (credit score, short codes).

- Lab2/
	- `Teacher (1).java` — manages an amusement-park trip simulation: removes misbehaving students, conducts trip flow, tracks money spent, first-aid and bus returns.
	- `Student (2).java` — student model for trip: permission slip, misbehavior flag, energy, nausea, fear, pocket money and methods to update them.
	- `Ride (1).java` — ride model: eligibility rules, ticket cost, energy/nausea/fear effects and application of effects.

- Lab3/
	- `ExamCell.java` — central scheduling/seat allocation manager (registries of halls and courses, clash detection, seat allocation skeletons).
	- `ExamCourse.java` — course + exam timeslot data holder.
	- `ExamHall.java` — room representation and seating logic (one-seat-gap policy) with seat assignment helpers.
	- `Student (3).java` — student type for exam scheduling (stores courses, getters used by ExamCell).

- Lab4/
	- `VibeManager (1).java` — simulation manager for campus events and tracking main-character selection logic.
	- `VibeCheck (1).java` — tracks rizz/delulu/confidence and a circular buffer for trends.
	- `Student (4).java` — student model for campus vibes and aura, with convenience methods.
	- `CampusEvent (1).java` — event type that updates student vibe and aura (applies multipliers based on trend).

- Lab6/
	- `Student (5).java` — placement-focused student (id parsing, CGPA, priority order, eligibility checks, thesis flag helpers).
	- `PSMS.java` — placement management system with nested PS1/PS2 classes for allocation (contains sorting/allocation scaffolding).
	- `Company.java` — company model (cutoffs, seats, selected student arrays and helper methods for selection).

Build & run (Windows / PowerShell)

Prerequisites

- Java JDK (11+) installed and on PATH. Confirm with:

	```powershell
	java -version
	javac -version
	```

Compile everything (recursively)

1) From the repository root (PowerShell):

```powershell
Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { javac $_.FullName }
```

This will compile every Java file into corresponding `.class` files in their folders. If there are compile errors, address them per-file.

Compile & run a single lab/main class

1) Example — compile and run `Processor` (Lab1):

```powershell
javac Lab1\Processor.java
java -cp Lab1 Processor
```

2) If classes depend on each other across packages (they don't use packages here), compile the entire lab folder first then run the intended main class.

Notes about running

- These exercises are small and intended to be run per-file or per-lab. Many classes are not complete programs with a `main` method — they are models and utilities used in evaluation scripts or unit tests.
- If you want runnable demos, I can add a `Main.java` per lab to exercise the main flows.

Testing and quick checks

- To quickly check for syntax errors (compile-only):

```powershell
Get-ChildItem -Recurse -Filter "*.java" | ForEach-Object { javac -Xlint $_.FullName } 
```

- For unit testing, consider adding JUnit and a lightweight Gradle or Maven setup. I can scaffold a Gradle build with JUnit 5 and a `build.gradle` if you'd like.

Branches, backups & restores

- Remote branches:
	- `origin/main` — default repository branch.
	- `origin/copilot/add-labs-information-repository` — contains extra metadata/changes.

- Local backup created during sync: `local-backup` contains previous un-synced files as a Git commit in this clone.

- ZIP backup created during sync (example path):
	- `C:\Users\Administrator\Downloads\OOPs_backup_20260328_164902.zip`

Restore options

- Restore from the Git backup branch:

```powershell
git checkout local-backup
```

- Or extract the ZIP to a folder and copy files back manually:

```powershell
Expand-Archive -LiteralPath 'C:\Users\Administrator\Downloads\OOPs_backup_20260328_164902.zip' -DestinationPath 'C:\Users\Administrator\Downloads\OOPs-restore'
```

Contributing, style, and TODOs

- Coding style: the repository currently uses simple Java classes without explicit packages. If you plan to expand the project, consider moving labs into packages (e.g., `labs.lab1`) and using a build system (Gradle/Maven).
- TODO ideas I can implement on request:
	- Add a Gradle wrapper + `build.gradle` to compile, run and test consistently.
	- Add a `Main` or `demo` class per lab to showcase typical usage and make the repo runnable.
	- Add JUnit tests for key methods (happy path + edge cases) and a GitHub Action to run them on push.

Contact & license

If you want me to continue improving this repository (add build scripts, tests, CI, or convert to packages), tell me which task to prioritize next.

---

Authors and history

The repository was synced from a remote (`https://github.com/Madhvansh/OOPs.git`) and updated locally. For a short history of recent commits, run:

```powershell
git log --oneline --decorate --graph -n 20
```

If you'd like, I can now:

- Add a `build.gradle` with tasks to compile and run per-lab.
- Add a `scripts/compile-all.ps1` PowerShell helper to compile all labs and collect `.class` files in a `build/` folder.

End of README

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
