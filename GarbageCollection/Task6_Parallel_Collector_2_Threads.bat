javac Runner.java
java -XX:+UseParallelGC -XX:ParallelCMSThreads=2 -Xms4m -Xmx16m -Xmn3m -XX:PermSize=24m -XX:MaxPermSize=32m Runner
