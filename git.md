# Работа с git

1. Создадим репозиторий на удаленном сервере (github.com)

https://github.com/ksenikeev/informatics.git

git@github.com:ksenikeev/informatics.git

```
…or create a new repository on the command line
echo "# informatics" >> README.md
git init
git add README.md
git commit -m "first commit"
git branch -M main
git remote add origin https://github.com/ksenikeev/informatics.git
git push -u origin main
```

```
…or push an existing repository from the command line
git remote add origin https://github.com/ksenikeev/informatics.git
git branch -M main
git push -u origin main
```

2. Создаем локальный репозиторий

VCS -> Enable version control ...

3. Добавление файла в систему контроля версий

git add file

либо в контекстном меню: git -> add

4. Фиксация состояния - COMMIT

git commit -m "first commit"

5. Подключение удаленного репозитория

git remote add origin https://github.com/ksenikeev/informatics.git

Git -> Manage remotes ...

6. Отправка коммита на удаленный репозиторий (PUSH)

git push -u origin main


