def call() {
    pipeline {
        agent any
        stages {
            stage('call') {
                steps {
                    script {
                      readYaml  
                    }
                }
            }
        }
    }
}
