
# CommandIterator

## Motivation

Checking argument indexes in a string array is too messy and makes sub-commands coupled to their location.

### The Solution

CommandIterator lets you forget about indexes but you can keep an imperative style of commands. Instead of checking indexes, you use `hasNext`, and instead of accessing indexes, you use `next`. It works like an `Iterator<String>`.

### Example

```java
CommandIterator command = new ArrayCommandIterator("arg1", "arg2");
if (!command.hasNext()) {
  sender.sendMessage("Usage");
  return;
}
String firstArgument = command.next(); // Will be "arg1"

if (!command.hasNext()) {
  sender.sendMessage("Specify next argument");
  return;
}
String secondArgument = command.next(); // Will be "arg2"
```

The call to `next()` consumes the argument. To view the argument without consuming it, you can use `peek()`.

### License

LGPL v3. See the license file for more info.
