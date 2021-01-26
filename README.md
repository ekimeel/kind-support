![Build](https://github.com/ekimeel/kind-support/workflows/Java%20CI%20with%20Gradle/badge.svg)
![Publish](https://github.com/ekimeel/kind-support/workflows/Publish/badge.svg)
# kind-support

Kind utilities for java dev

## Nulls

### Coalesce
Coalesce returns the first non-null value in the expression list. You must specify at least two expressions. If all occurrences of expr evaluate to null, then the function returns null.

This function uses short-circuit evaluation. The database evaluates each expr value and determines whether it is NULL, rather than evaluating all of the expr values before determining whether any of them is NULL.

_Example:_
```java
import static kind.support.Coalesce.*;
...
final String one, two, three;
one = null; two = null; three = "world!";
System.out.println("Hello " + coalesce(one, two, three));

```