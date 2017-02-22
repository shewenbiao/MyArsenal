## Use TODO Comments
Use TODO comments for code that is temporary, a short-term solution, or good-enough but not perfect. TODOs should include the string TODO in all caps, followed by a colon:

 > // TODO: Remove this code after the UrlTable2 has been checked in.

and

 > // TODO: Change this to use a flag instead of a constant.

If your TODO is of the form "At a future date do something" make sure that you either include a very specific date ("Fix by November 2005") or a very specific event ("Remove this code after all production mixers understand protocol V7.").

***

## Use Spaces for Indentation

### Blocks
1.We use four (4) space indents for blocks and never tabs. When in doubt, be consistent with the surrounding code. For example:

```java
class MyClass {
    int func() {
        if (something) {
            // ...
        } else if (somethingElse) {
            // ...
        } else {
            // ...
        }
    }
}
```
### Line-wrapping
**Terminology Note:** When code that might otherwise legally occupy a single line is divided into multiple lines, this activity is called line-wrapping.

**Note:** While the typical reason for line-wrapping is to avoid overflowing the column limit, even code that would in fact fit within the column limit may be line-wrapped at the author's discretion.

We use eight (8) space indents for line wraps, including function calls and assignments. For example:

```java
Instrument i =
        someLongExpression(that, wouldNotFit, on, one, line);
```
***

## Limit Line Length
Each line of text in your code should be at most 100 characters long. While much discussion has surrounded this rule, the decision remains that 100 characters is the maximum with the following exceptions:

* If a comment line contains an example command or a literal URL longer than 100 characters, that line may be longer than 100 characters for ease of cut and paste.
* Import lines can go over the limit because humans rarely see them (this also simplifies tool writing).


***

## Statement
* One statement per line.
* Each statement is followed by a line break.

***
