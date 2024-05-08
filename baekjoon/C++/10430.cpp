#include <iostream>

using namespace std;

int main() {
  int n1;
  int n2;
  int n3;

  cin >> n1 >> n2 >> n3;

  cout << (n1+n2)%n3 << endl;
  cout <<  ((n1%n3) + (n2%n3))%n3 << endl;
  cout << (n1*n2)%n3 << endl;
  cout << ((n1%n3)*(n2%n3))%n3 << endl;
}