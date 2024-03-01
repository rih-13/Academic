%QUESION 1 - Ria Haque 
man(john1).
man(peter).
man(rob).
man(george).
man(john2).
man(jay).
woman(sue).
woman(ida).
woman(estelle).
woman(grace).
woman(mary).

married(john,sue).
married(peter,ida).
married(george,estelle).

parent(john1, estelle).
parent(sue,estelle). % means sue is parent of estelle
parent(john1, rob).
parent(sue, rob).

parent(peter, george).
parent(ida, george).
parent(ida, grace).
parent(peter, grace).

parent(estelle, john2).
parent(george, john2).
parent(george, mary).
parent(estelle, mary).
parent(estelle, jay).
parent(george, jay).

% GRANDFATHER/GRANDPARENT
father(F,C):-man(F),parent(F,C).
mother(M,C):-woman(M),parent(M,C).
grandparent(G,C) :- parent(G,P), parent(P,C). 
grandfather(G,C) :- grandparent(G,C), man(G).

%ANCESTOR
ancestor(A,D) :- parent(A,D).
ancestor(A,D) :- parent(P,D), ancestor(A,P).

% SIBLINGS AND UNCLE
siblings(A,B):-father(F,A),father(F,B), mother(M, A), mother(M,B), F\=M, A\=B. %assuming full siblings
brother(B,C) :- siblings(B,C), man(B). % means B is a brother of C
uncle(U,N) :- parent(P,N), brother(U,P). %UNCLE
a_pair_of_brother(B,C) :- siblings(B,C), man(B), man(C).
%MOTHER IN LAW
mother_in_law(M,S) :- mother(M,W), married(S,W). %for son in law
mother_in_law(M,D) :- mother(M,H), married(H,D). % for daughter in law




%QUESTION 2

city(chicago).
city(toronto).
city(detroit).
city(orlando).
city(vancouver).
city(new_york).

american(chicago).
american(detroit).
american(orlando).
american(new_york).
canadian(toronto).
canadian(vancouver).

airport(chicago, ohare).
airport(chicago, midway). 
airport(toronto,pearson).
airport(toronto,bishop).
airport(detroit, wayne).
airport(detroit, city).
airport(orlando, international).
airport(orlando, sanford).
airport(vancouver, international2).
airport(vancouver, coal_harbour).
airport(new_york, la_guardia).
airport(new_york, jfk).
airport(new_york, newark).

hero(ohare).
hero(ohata).
hero(okubo).
hero(mccarter).
hero(hawkins).
hero(harris).
battle(midway).
battle(stalingrad).
battle(berlin).
battle(iwo_jima).

query(C) :-
    airport(C, A), hero(A),
    airport(C, B), battle(B), A\=B, american(C). %if airport name is war hero, airport 2 is battle, city is american 

% QUESTION 3
last(X,[X]).  %base case - one member in tail 
last(X,[_|Z]) :- last(X,Z).

 
adjacent(X, Y, [X,Y|_]). %if the first two elements are xy
adjacent(X, Y, [_|Tail]) :- adjacent(X, Y, Tail). %if xy are in tail 

palindrome(X) :- reverse(X, X). %if reverse is the same as original 

%QUESTION 4

fib(1, 0). %base case - starting point 
fib(X, Y) :- fib(Y,Z), X is Y + Z.
        
%QUESTION 5

sum([X],X). %if the only in the list 
sum([X|Tail],S) :- sum(Tail,Y),S is X+Y.

mean([X],X). %base case
mean(X,M):- length(X,L), sum(X,S), M is S/L.

min([X],X). %base case
min(X,M) :- length(X,L), L > 1,
    sort(X,[Head|_]), M is Head.

max([X],X). %base case
max(X,M) :- length(X,L), L > 1,
    sort(X,[_|Tail]), max(Tail, M2), M is M2.