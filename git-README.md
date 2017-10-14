### Author:IT民工
### E-mail:jackluo2017@126.com

# 常用命令

git init
git add readme.txt
git commit -m 'change1'
git status
git diff
git reset --hard HEAD^
git reset --hard a3f2ab4
git checkout -- log.txt
   
# 关联一个远程库
git remote add origin git@github.com:luohao2016/gitsample.git

# 第一次推送master分支的所有内容
git push -u origin master
如果报错“error: failed to push some refs to 'git@github.com:luohao2016/gitsample.git'”，
因为服务器上有内容，不能覆盖，就执行下面语句：
git push -f -u origin master

此后，每次本地提交后，只要有必要，就可以使用命令
git push origin master

# 分支操作：
查看分支：git branch
创建分支：git branch <name>
切换分支：git checkout <name>
创建+切换分支：git checkout -b <name>
合并某分支到当前分支：git merge <name>
删除分支：git branch -d <name>


## 查看远程库信息，使用git remote -v；


## 从本地推送分支，使用git push origin branch-name，如果推送失败，先用git pull抓取远程的新提交；

## 在本地创建和远程分支对应的分支，使用git checkout -b branch-name origin/branch-name，本地和远程分支的名称最好一致；

## 建立本地分支和远程分支的关联，使用git branch --set-upstream branch-name origin/branch-name；

## 从远程抓取分支，使用git pull，如果有冲突，要先处理冲突。
