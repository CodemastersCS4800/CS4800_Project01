(*
* Brayden Tanji
* CS 4080
* SML Programming Assignment 1
*)


(* Find last element in list *)
fun find_last_acc [] acc = acc
| find_last_acc (x::xs) acc = find_last_acc xs x;
fun find_last alist = find_last_acc alist 0;

(* Find an element at a given n in a list (with exception handling) *)
exception IndexOverEndOfList;
fun element_at (x::xs) 0 = x
| element_at [] n = raise IndexOverEndOfList  
| element_at (x::xs) n = element_at xs (n-1);

(* find the size of the list no error handling*)
fun size_acc [] acc = acc
| size_acc (x::xs) acc = size_acc xs (acc+1);
fun size alist = size_acc alist 0;

(* Palindrome *)
fun reverse_TR [] acc = acc
| reverse_TR (x::xs) acc = reverse_TR xs (x::acc);
fun revers alist = reverse_TR alist [];

fun is_palindrome alist = (alist = revers alist);

(* No Dup *)
fun sort [];

fun no_dup alist;
