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
                echo '🐳 Construyendo imagen Docker (incluye Maven)'
                sh 'docker build -t calculadora-backend:latest .'
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Desplegando backend'
                sh '''
                  docker-compose down
                  docker-compose up -d
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
