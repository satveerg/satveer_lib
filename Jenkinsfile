pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                   def datas = readYaml file: 'Routes.yml'
                   println datas.branchrules.key.branchname
                   
               }
           }
       }
   }
}
