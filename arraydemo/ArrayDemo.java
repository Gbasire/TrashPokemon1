package arraydemo;

import java.util.Arrays; // This import is neccecary to be able to print the arrays nicely

@SuppressWarnings("unused") // A simple way to get rid of warnings that you don't care about - but not really recommended.
public final class ArrayDemo {

//   ↓ Click to run program  -  ↓ That's also an array of strings!
    public static void main(String[] args) {

        // -- What are arrays --

        // Arrays are basically a container for a number of items of the same type.
        // Arrays have a fixed size that is defined when intantiating one. That means
        // you can't 'add' an object to an array, but you set the value of an element
        // at a specific index.
        //
        // Arrays are 0-indexed. That means the first element has the index 0, the
        // second one the index 1, and so on. Thus the index of the last element of
        // an array with the length 'n' has the index 'n-1'.
        //
        // Imagine them like this:
        //
        // [object1, object2, object3, object4] --> Array
        //     ↑        ↑        ↑        ↑
        //     0        1        2        3     --> Index (0-3)
        //
        //     |--------------------------|     --> Length 4
        // 


        // -- Declaring arrays --

        int[] integerArray; // This is an array, can be of any type

        String[] stringArray;
        boolean[][] multiBooleanArray; // Arrays can even contain arrays ('multidimensional arrays')


        // -- Instantiating arrays --
        
        integerArray = new int[10]; // Create a new int array of length 10
                                    // By default, all 10 elements in the array have the value 0 assigned.
                                    // Arrays of primitives (int, double, boolean,..., NOT String) will have
                                    // their default value assigned (0/false). Arrays of other types will
                                    // default all values to null.
        stringArray = new String[10]; // Here all elements have the value null.

        stringArray = new String[] {"Hello", " ", "World", "!"}; // This way we create an array of length 4
                                                                 // with the given values assigned to each
                                                                 // index. Note that there is NO size defined
                                                                 // in the brackets.

        integerArray = null; // Arrays are a subclass of Object and not a primitive, so they can be null


        // -- Reading / assigning elements --

        String hello = stringArray[0]; // This returns the first element of the array - in this case "Hello".
        System.out.println(hello);

        stringArray[3] = "?"; // Sets the value of the fourth field of the array to "?".

        //stringArray[4] = "index 4"; This would throw an ArrayIndexOutOfBoundsExceception, because an array
                                   // of length 4 only has the indecies 0, 1, 2 and 3-

        int stringArrayLength = stringArray.length; // This returns the length of the array - in this case 4.

        // stringArray.length = 5; this does not work - you cannot simply change the size of an array.

        
        // -- Printing arrays --

        System.out.print("This happens if you print out an array: ");
        System.out.println(stringArray); // Pretty annoyingly, arrays don't print their content but their
                                         // content type with an '[L' before.

        System.out.println(Arrays.toString(stringArray)); // This is a simple way to print out the array nicely.
                                                          // Note the 'import java.util.Arrays' at the very top.


        // -- Arrays and for-loops --

        System.out.println("for loop:");

        // Classic for loop:
        for(int i=0; i<stringArray.length; i++) {
            // This will iterate through the numbers 0 - array.length-1 (so here 0-3) and therefore perform
            // the operation on each array element.
            System.out.println("The " + (i+1) + ". element (index " + i + ") in the array has the value '" + stringArray[i] + "'");

            stringArray[i] += "_"; // You can obviously also assign like this
        }

        System.out.println("for-each loop:");

        // 'for-each' loop:
        for(String string : stringArray) {
            System.out.println(string); // The variable 'string' will take the value of each element once.

            // However here you don't get the current index as variable.
            // Also this ain't have an effect:
            string = "Nothing";
        }

        // As you can see, nothing changed.
        System.out.println("After for-each loop: " + Arrays.toString(stringArray));
    }
}
