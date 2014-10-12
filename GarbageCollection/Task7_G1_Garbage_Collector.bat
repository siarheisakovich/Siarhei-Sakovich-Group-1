javac Runner.java
java -XX:+UseG1GC -Xms4m -Xmx16m -Xmn2m -XX:PermSize=12m -XX:MaxPermSize=18m Runner
