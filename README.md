# Four Russians Algorithm implementation
## For SE HSE Computation Complexity course

The Method of Four Russians is a technique for speeding up algorithms involving Boolean matrices, or more generally algorithms involving matrices in which each cell may take on only a bounded number of possible values.

In this program you can find preprocessing of the matrices with separating its submatrices and multiplication of matrices using the result of preprocessing.

Tests check the correctness of multiplication.

## Test and Run


Running tests

```sh
mvn test
```
Running the program with algorithm

```sh
java -jar target/4RussiansAlgorithm-1.0-SNAPSHOT.jar
```
Recompile the program with tests and then run

```sh
mvn clean install
java -jar target/4RussiansAlgorithm-1.0-SNAPSHOT.jar
```