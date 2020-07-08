## Getting Started

#### Reference Documentation
How to Use Own Local Docker Images With Minikube
* https://medium.com/bb-tutorials-and-thoughts/how-to-use-own-local-doker-images-with-minikube-2c1ed0b0968
Summary
Minikube comes with its own docker daemon and not able to find images by default
We need to set the environment variables with eval $(minikube docker-env).
We need to build the docker image after we set the environment variables above and make sure to tag the image as same as in the deployment yaml file.
We have to set ImagePullPolicy to Never in order to use local docker images with the deployment.
We can unset the environment variables with this command eval $(minikube docker-env -u)

#### Build Application
```
./gradlew clean && ./gradlew build
```

#### Run minikube cluster
```
minikube start
```
```
eval $(minikube docker-env)
```
```
docker-compose build
```
```
update netinfo-loadbalancer-service.yaml with minikube ip
```
```
kubectl apply -f ./k8s/minikube
```
```
http://<minikube ip>:8086/
http://192.168.64.9:8086/
```
```
minikube delete
```

#### Run GCP cluster
```
./gradlew clean && ./gradlew build
```
```
docker-compose build
```
```
docker tag gcp-k8s-spring_netinfo eu.gcr.io/kube-proj-272213/netinfo
```
```
gcloud auth configure-docker
```
```
docker push eu.gcr.io/kube-proj-272213/netinfo
```
```
GCP console -> Kubernetes Engine -> Create cluster (with three nodes)
```
```
GCP console -> Kubernetes Engine -> Cluster -> connect 
Example:
gcloud container clusters get-credentials cluster-1 --zone europe-west3-a --project kube-proj-272213
```
```
kubectl get services
Example:
NAME                           TYPE           CLUSTER-IP     EXTERNAL-IP      PORT(S)          AGE
kubernetes                     ClusterIP      10.64.0.1      <none>           443/TCP          15m
mysql-clusterip-service        ClusterIP      10.64.2.233    <none>           3306/TCP         3m59s
netinfo-loadbalancer-service   LoadBalancer   10.64.12.151   35.198.101.248   8086:30002/TCP   3m58s
```
```
curl 35.198.101.248:8086 | jq
Example:
  % Total    % Received % Xferd  Average Speed   Time    Time     Time  Current
                                 Dload  Upload   Total   Spent    Left  Speed
100   127    0   127    0     0    969      0 --:--:-- --:--:-- --:--:--   976
{
  "id": null,
  "ipAddress": "10.0.0.3",
  "hostName": "netinfo-deployment-6f87778576-jj8kh",
  "timestamp": "2020-07-09T07:52:23.673+00:00"
}
```
