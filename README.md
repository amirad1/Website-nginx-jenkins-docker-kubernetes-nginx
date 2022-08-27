Building, testing and deploying a simple website from scratch

1.	First change the DOCKER IMAGE NAME in docker-compose.yaml file to your docker hub repository image name like myuser/myapp:mytag and trigger pipeline by a committing or starting jenkins pipeline manually 

2.	Change the image name in Kubernetes yaml file as same as above

3.	I used 4 different virtual machines to run this app(Kubeadm master, Worker node, Docker, Jenkins) and ran my commands by ssh in jenkinsfile. You can use one or two machines by running all tools in the same machines like using minikube or mikroK8s 

4.	I used two approach in Jenkins, first with running ssh manually in pipeline and second with creating node agents and addressing my machine IP and ssh credential in agents. For first approach you should jenkinsfile and for second approach you should use agent.groovy file

Enjoy !
