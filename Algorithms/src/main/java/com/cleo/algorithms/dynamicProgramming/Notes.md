## In a DP problem, a state is a set of variables that can sufficiently describe a scenario. These variables are called state variables, and we only care about relevant ones. For example, to describe every scenario in Climbing Stairs, there is only 1 relevant state variable, the current step we are on. We can denote this with an integer
i
i. If
i = 6
i = 6, that means that we are describing the state of being on the 6th step. Every unique value of
i
i represents a unique state.
## To solve a DP problem, we need to combine 3 things:

1. **A function or data structure that will compute/contain the answer to the problem for every given state.** For Climbing Stairs, let's say we have an function dp where dp(i) dp(i) returns the number of ways to climb to the i th step. Solving the original problem would be as easy as return dp(n) How did we decide on the design of the function? The problem is asking "How many distinct ways can you climb to the top?", so we decide that the function will represent how many distinct ways you can climb to a certain step - literally the original problem, but generalized for a given state.
2. **A recurrence relation to transition between states.** A recurrence relation is an equation that relates different states with each other. Let's say that we needed to find how many ways we can climb to the 30th stair. Well, the problem states that we are allowed to take either 1 or 2 steps at a time. Logically, that means to climb to the 30th stair, we arrived from either the 28th or 29th stair. Therefore, the number of ways we can climb to the 30th stair is equal to the number of ways we can climb to the 28th stair plus the number of ways we can climb to the 29th stair.** The problem is, we don't know how many ways there are to climb to the 28th or 29th stair. However, we can use the logic from above to define a recurrence relation. In this case,
dp(i) = dp(i - 1) + dp(i - 2)
dp(i) = dp(i - 1) + dp(i - 2). As you can see, information about some states gives us information about other states.
Upon careful inspection, we can see that this problem is actually the Fibonacci sequence in disguise! This is a very simple recurrence relation - typically, finding the recurrence relation is the most difficult part of solving a DP problem. We'll see later how some recurrence relations are much more complicated, and talk through how to derive them.
3. **Base cases, so that our recurrence relation doesn't go on infinitely.**

The equation
dp(i) = dp(i - 1) + dp(i - 2)
dp(i) = dp(i - 1) + dp(i - 2) on its own will continue forever to negative infinity. We need base cases so that the function will eventually return an actual number.

Finding the base cases is often the easiest part of solving a DP problem, and just involves a little bit of logical thinking. When coming up with the base case(s) ask yourself: What state(s) can I find the answer to without using dynamic programming? In this example, we can reason that there is only 1 way to climb to the first stair (1 step once), and there are 2 ways to climb to the second stair (1 step twice and 2 steps once). Therefore, our base cases are
dp(1) = 1
dp(1) = 1 and
dp(2) = 2
dp(2) = 2.

We said above that we don't know how many ways there are to climb to the 28th and 29th stairs. However, using these base cases and the recurrence relation from step 2, we can figure out how many ways there are to climb to the 3rd stair. With that information, we can find out how many ways there are to climb to the 4th stair, and so on. Eventually, we will know how many ways there are to climb to the 28th and 29th stairs.
