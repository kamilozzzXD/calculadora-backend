pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'develop',
                    url: 'https://github.com/kamilozzzXD/calculadora-backend.git'
            }
        }

        stage('Build JAR') {
            steps {
                echo '⚙️ Compilando backend con Maven'
                sh 'mvn clean package -DskipTests'
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
                echo '🚀 Desplegando aplicación'
                sh '''
                  docker compose down
                  docker compose up -d
                '''
            }
        }
    }

    post {
        failure {
            echo '❌ Error en el pipeline del backend'
        }
        success {
            echo '✅ Pipeline ejecutado correctamente'
        }
    }
}
