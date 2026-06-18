# BDD Demo Project

Run tests locally (Windows PowerShell):

- Headed mode:

```powershell
mvn test
```

- Headless mode:

```powershell
mvn -Dheadless=true test
```

CI (GitHub Actions): the workflow in `.github/workflows/ci.yml` runs the tests and uploads cucumber reports as artifacts.
