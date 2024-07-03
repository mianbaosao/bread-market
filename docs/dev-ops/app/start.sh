CONTAINER_NAME=big-market
IMAGE_NAME=system/big-market:1.0-SNAPSHOT
PORT=8091

echo "容器部署开始 ${CONTAINER_NAME}"

# 停止容器
docker stop ${CONTAINER_NAME}

# 删除容器
docker rm ${CONTAINER_NAME}

# 启动容器
docker run --name ${CONTAINER_NAME} \
-p ${PORT}:${PORT} \
-d ${IMAGE_NAME}

echo "容器部署成功 ${CONTAINER_NAME}"

docker logs -f ${CONTAINER_NAME}