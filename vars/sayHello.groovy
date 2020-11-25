def call(body) {
    def pipelineParams= [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = pipelineParams
    body()

    pipeline {
        agent any
        environment {
            BRANCH_NAME = "${env.GIT_BRANCH}"
            //output = readYaml('${env.GIT_BRANCH}')
            output = readYaml(sprint-dev-aps) 
        }
        stages {
            stage('call') {
                steps {
                       sh """
                       echo Branch name is $BRANCH_NAME
                       echo "env name is ${env.output}"
                        """
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
