pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                echo '📥 Clonando repositorio'
                git branch: 'develop',
                    url: 'https://github.com/kamilozzzXD/calculadora-backend.git'
            }
        }

        stage('Build JAR (Maven)') {
            steps {
                echo '⚙️ Compilando backend'
                sh '''
                  cd backend
                  mvn clean package -DskipTests
                '''
            }
        }

        stage('Build Docker Image') {
            steps {
                echo '🐳 Construyendo imagen Docker'
                sh '''
                  cd backend
                  docker build -t calculadora-backend:latest .
                '''
            }
        }

        stage('Deploy') {
            steps {
                echo '🚀 Desplegando backend'
                sh '''
                  docker compose down
                  docker compose up -d
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
