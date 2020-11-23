pipeline {
   agent { label 'master' }
   stages {
       stage('write') {
           steps {
               script {
                   sh """
                   echo --- 
                     branchrules: 
                       platform: 
                         branchname: sprint-dev-aps
                       targets: 
                         environment: ram-dev-10 > manifest.yml
                     """
                   def datas = readYaml file: 'manifest.yml'
                   println datas.branchrules.key.branchname
                   
               }
           }
       }
   }
}
