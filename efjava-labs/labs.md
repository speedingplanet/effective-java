# Effective Java Labs

## Generics Lab

In `org.efjava.labs`, we have four classes: `Media`, the parent type for `Book` and `Movie`; as well
as `Library` which will be a custom container for `Media`. 

1. Build out classes: 
   1. `Media` to have a `creator` and a `title`. Add a constructor, getter, setter, etc.
   2. Build out `Book` to have an `author` and a `title`. The `author` should map to `Media`'s 
      `creator`. Add a constructor, getters. and setters.
   3. Build out `Movie` to have a `director`, `title`, and `year`. The `director` should map
      to `Media`'s `creator`. Add a constructor, getters, and setters
2. Build `Library`. In particular: 
   1. It should have `add` and `remove` methods. These methods should be
      able to add and remove anything that is the generic type for the library
   2. Include an `asList` method, taking an argument of a destination collection
3. Write tests for `Library`. Specifically:
   1. Test `add` to make sure that both a `Book` and a `Movie` could be added
   2. Test `remove` to make sure that both a `Book` and a `Movie` could be removed
   3. Create a `Library` of `Book`s. Call `asList`, passing in a `Collection<Media>`

## Optionals Lab

1. Add two methods to `Library`:
   1. `findByCreator` should take a `String` as an argument and return an `Optional`
   2. `findByTitle` should take a `String` as an argument and return an `Optional`
2. Test `findByCreator`
   1. One test should check to see if it can find a searched-on creator
   2. One test should check to see if it returns an empty `Optional` if the creator isn't found
   3. What would `findAllByCreator` look like?
3. Work with `findByTitle` in a test
   1. Use `orElse` to print something when the title is not found in the `Optional`
   2. Use `orElseGet` to print something when the title is not found in the `Optional`
   3. Create a custom Exception `TitleNotFound`, throw it when the title is not found in the `Optional`
