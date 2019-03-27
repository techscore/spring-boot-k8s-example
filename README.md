# SpringBoot/Kotlin/Kubernetes example

## local 起動

    ./gradlew example-api-server:bootRun

## 動作確認

    $ curl http://localhost:8080/hello/
    {"message":"Hello guest !!"}


## deploy local k8s

    ./gradlew example-api-server:jibDockerBuild
    
    # manifestの確認
    kubectl kustomize k8s/dev
    
    # apply
    kubectl apply -k k8s/dev
    
    # cleanup
    kubectl delete -k k8s/dev





