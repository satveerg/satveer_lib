def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    pipeline {
        agent any
        stages {
            stage('print') {
                steps {
                    sh """
                    echo "India is Great"
                    """
                }
            }
            stage('call') {
                steps {
                    script {
                     def output = readYaml('sprint-dev-aps')
                     pritnln $output
                      sh 'echo Running library'
                    }
                }
            }
        }
    }
}
