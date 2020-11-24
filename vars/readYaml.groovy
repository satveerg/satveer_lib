#!/usr/local/bin/groovy

def call() {
    def filecontent=libraryResource "com/marriott/platform/Routes.yml"
	  def pipelineRulesList = yaml.load(filecontent)
}
