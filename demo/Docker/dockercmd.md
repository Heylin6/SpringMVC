[專案下到有 Dockerfile 的位置]

docker build -f Dockerfile

[建立 Image]

docker build -f Dockerfile .

[查看image列表]

docker image ls

[查看容器列表]

docker ps

[查看運行中的容器]

docker ps -a

[刪除某容器]

docker rm [container]

[停止某容器]

docker stop [container]