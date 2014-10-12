javac Runner.java
java -XX:+UseConcMarkSweepGC -XX:ParallelCMSThreads=2 -Xms2m -Xmx18m -Xmn1m -XX:PermSize=24m -XX:MaxPermSize=36m Runner
