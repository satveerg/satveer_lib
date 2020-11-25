def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent any
        environment {
            BRANCH_NAME = "${env.GIT_BRANCH}"
            output = readYaml(${env.GIT_BRANCH})
        }
        stages {
            stage('call') {
                steps {
                       sh '''
                       echo Branch name is $BRANCH_NAME
                       echo env name is $output
                       printenv
                        '''
                }
            }
            stage('when') {
                when {
                    expression {
                        return env.output != null
                    }
                }
                steps {
                    sh 'echo exectuting when'
                }
            }
        }
    }
}
