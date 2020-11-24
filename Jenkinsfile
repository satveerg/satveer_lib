pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                  def call(String APP) {
                  return $APP
                  }
                   
               }
           }
       }
      stage('call') {
         steps {
            script {
            ab=(satveer)
               println $ab
            }
         }
      }
   }
}
