def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent any
        environment {
            output = readYaml('sprint-dev-aps')
            branchname = ${GIT_BRANCH}
        }
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
                       sh '''
                       echo This environment name is $output
                       echo $branchname
                        '''
                    }
                }
            }
        }
    }
}
