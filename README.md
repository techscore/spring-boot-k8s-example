# SpringBoot/Kotlin/Kubernetes example

## local 起動

    ./gradlew example-api-server:bootRun

## 動作確認

    $ curl http://localhost:8080/hello/
    {"message":"Hello guest !!"}


## deploy local k8s

    ./gradlew example-api-server:jibDockerBuild
    
    kustomize build k8s/dev | kubectl apply -f -
    
    # cleanup
    kustomize build k8s/dev | kubectl delete -f -





