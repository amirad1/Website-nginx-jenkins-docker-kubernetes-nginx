pipeline {
agent none
    stages {
        stage('Example Build') {
            agent {
                label 'docker'
            }
            steps {
                sh 'docker-compose up --build -d'
            }
        }
        stage('Test image existence') {
            agent {
                label 'docker'
            }
            steps{
                sh 'cd /root/docker && bash image-test.sh'
            }
        }
        stage('Test running container') {
            agent {
                label 'docker'
            }
            steps{
                sh 'cd /root/docker && bash container-test.sh'
            }
        }
        stage('Push to Docker hub'){
            agent { label 'docker' }
            steps{
                sh 'docker push site'
            }
        }
            stage('deploy'){
        agent {
                label 'kubernetes'
    }
                steps{
                    sh 'cd /root && kubectl apply -f dep.yaml'
            }
        }
    }
    post {
        always {
            junit 'reports.xml'
        }
        success {
            echo "pipeline executed sucsessfuly"
        }
    }
}