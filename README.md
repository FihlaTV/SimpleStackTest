# Simple Stack example for multiple stacks in activity/fragment

Based on [simple-stack](https://github.com/Zhuinden/simple-stack/) library

This example shows how to have multiple stacks to represent application state in both activity and fragment using fragment approach.

This shows one way how to separate fragments on different scope using different stacks based on [simple-stack](https://github.com/Zhuinden/simple-stack/) library. If there is any better way feel free to comment.

## What this example serves for?

Why using multiple stacks to represent application state? There is one common scenario to show the use case.

Imagine your application has one full page view with a button at the beginning. When you click the button it turns to a page with different tabs using BottomNavigationView. You can switch different tabs without stacking the history. History will be stored in individual stacks.


