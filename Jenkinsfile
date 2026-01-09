pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo '📥 Clonando repositorio backend'
                git branch: 'develop',
                    url: 'https://github.com/kamilozzzXD/calculadora-backend.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                echo '🐳 Construyendo imagen Docker'
                sh 'docker build -t calculadora-backend:latest .'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Desplegando backend'
                sh '''
                  docker stop calculadora-backend || true
                  docker rm calculadora-backend || true

                  docker run -d \
                    --name calculadora-backend \
                    -p 8080:8080 \
                    calculadora-backend:latest
                '''
            }
        }
    }

    post {
        success {
            echo '✅ Backend desplegado correctamente'
        }
        failure {
            echo '❌ Error en el pipeline del backend'
        }
    }
}
