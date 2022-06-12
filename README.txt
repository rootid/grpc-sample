
1. Update the IDL
2. Generate code/update code
mvn -DskipTests package
OR
protoc --plugin=protoc-gen-grpc-java=$PATH_TO_PLUGIN -I=$SRC_DIR
  --java_out=$DST_DIR --grpc-java_out=$DST_DIR $SRC_DIR/HelloService.proto
3. Implement the service
4. Update server and client
5. Start the server
mvn exec:java -Dexec.mainClass=com.example.grpc.GrpcServer
6. Start the client
mvn exec:java -Dexec.mainClass=com.example.grpc.GrpcClient


