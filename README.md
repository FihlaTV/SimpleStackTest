# Simple Stack example for multiple stacks in activity/fragment

Based on [simple-stack](https://github.com/Zhuinden/simple-stack/) library

This example shows how to have multiple stacks to represent application state in both activity and fragment using fragment approach.

This shows one way how to separate fragments on different scope using different stacks based on [simple-stack](https://github.com/Zhuinden/simple-stack/) library. If there is any better way feel free to comment.

There is also parts to demonstrate how Anko can be used in 
to create UI for the layout and create custom layout which customization can be made

* Create UI for the layout in view/fragment/activity...
* Create custom layout which customization can be made using method for some preset behaviour.    

## What this example serves for?

Why using multiple stacks to represent application state? There is one common scenario to show the use case.

Imagine your application has one full page view with a button at the beginning. When you click the button it turns to a page with different tabs using BottomNavigationView. You can switch different tabs without stacking the history. History will be stored in individual stacks.

The gif shows what the project serves.

<p align="center">
<img alt='Sample' src="https://raw.githubusercontent.com/elton2048/SimpleStackTest/master/art/example.gif"></br>
</p>

## Anko layout

See DashboardBlock for detail how UI is created and used in fragment.

For custom layout, [BlockLayout](https://github.com/elton2048/SimpleStackTest/tree/master/feature/src/main/java/elton/com/simplestacktest/utils/ankolayout/BlockLayout.kt) and [TitleBar](https://github.com/elton2048/SimpleStackTest/tree/master/feature/src/main/java/elton/com/simplestacktest/utils/ankolayout/TitleBar.kt) are the example how it can be done and how the preset behaviour set.