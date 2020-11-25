def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()
    println output
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
                      println output
                       sh '''
                       echo $output
                        echo Running library
                        '''
                    }
                }
            }
        }
    }
}
