# SuggesterFX

**SuggesterFX** is a JavaFX lightweight library that provides a suggestion (autocompletion) 
system for text fields linked to data entries.
This library integrates with [mvciFX library](https://github.com/barmat80/mvciFX)
to provide a clean, maintainable architecture for handling suggestions and autocompletion.

## Credits

- Original MVCI framework concept by Dave Barrett ([PragmaticoCoding](https://www.pragmaticcoding.ca)).
- Built on [ControlsFX](https://github.com/controlsfx) components
- Autocompletion modifications based on [Clément Grennerat's post](https://github.com/controlsfx/controlsfx/issues/883#issuecomment-1147602490) 
and his [PDF4Teachers application](https://github.com/ClementGre/PDF4Teachers)

## Overview

SuggesterFX combines JavaFX's text fields with ControlsFX's autocompletion features, 
wrapped in an MVCI (Model-View-Controller-Interactor) architecture. 
This makes it easy to implement type-ahead suggestions while maintaining clean separation of concerns.

## Features

This library provides the following components:
- `SuggestionInteractor`: an abstract MVCI Interactor class specialized for suggestions handling
  - fetches entries based on partial user input
  - retrieves text autocompletion
  - manages model updates after successful autocompletion
- `Entry`: an interface representing data entities (such as POJOs) that can be used with 
    the suggestion system.
  - Supports composite primary keys
  - Provides description text for display
- Suggestion Components:
  - `EntryConverter`: converts between `Entry` objects and their string representations.
  - `EntrySelectionHandler`: handles the selection events from autocompletion textfield.
  It uses the `SuggestionInteractor` to handle what should be done after the operation is completed.
  - `EntrySuggesterCallback`: a callback backed by the `SuggestionInteractor.fetchEntries(String)` method, 
  which retrieves entries based on a user's suggestion or partial input.
  - `StringSuggesterCallback`: a callback backed by to `SuggestionInteractor.fetchNames(String)` method, 
  which retrieves a list of names matching a user's suggestion or partial input

## ControlsFX autocompletion widgets and classes

The classes in `com.maemlab.suggesterfx.controlsfx.autocompletion` package are taken from ControlsFX.
They have been repackaged and modified following [Clément Grennerat's post](https://github.com/controlsfx/controlsfx/issues/883#issuecomment-1147602490).

- `impl.textfield.AutoCompletionBinding`:
  - Removed EventTarget implementation
  - Simplified `fireAutoCompletion` method: 
  - Made `isCancelled` and `getUserText` methods public
  - Removed `invalidated` method
- `impl.textfield.TextFields`: removed `createClearablePasswordField` method
- `impl.textfield.AutoCompletionTextFieldBinding`: a little bit of code review
- `impl.skin.AutoCompletePopupSkin`: removed the default style

# Examples

TODO

## Example 1:

TODO

# Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue.