#include <stdlib.h>
#include <stdio.h>
#include <string.h>

typedef struct entry_tag entry_t;

struct entry_tag {
  char * key;
  int value;
  entry_t * left;
  entry_t * right;
};

typedef struct {
  entry_t * root;
} tree_map;

tree_map * new_tree_map() {
  tree_map * tree = (tree_map*)malloc(sizeof(tree_map));
  tree->root = NULL;
  return tree;
}

entry_t * new_tree_entry(char * key, int value) {
  entry_t * entry = (entry_t *)malloc(sizeof(entry_t));
  entry->key = key;
  entry->value = value;
  entry->left = NULL;
  entry->right = NULL;
  return entry;
}

void update(tree_map* tree, char * key, int value) {
  if (tree->root == NULL) { //tree empty
    tree->root = new_tree_entry(key, value);
    return;
  }
  entry_t * curr = tree->root;
  while(curr) {
    int res = strcmp(key, curr->key);
    if (res == 0) { // found it
      curr->value = value;
      return;
    } else if (res < 0) {//go left
      if (curr->left == NULL) {
        curr->left = new_tree_entry(key, value);
        return;
      } else {
        curr = curr->left;
      }
    } else if (res > 0) {//go right
      if (curr->right == NULL) {
        curr->right = new_tree_entry(key, value);
        return;
      } else {
        curr = curr->right;
      }
    }
  }
}

void print_tree_entry(entry_t * entry) {
  if (entry == NULL) return;
  else {
    print_tree_entry(entry->left);
    printf("key: %s - value: %d\n", entry->key, entry->value);
    print_tree_entry(entry->right);
  }
}
void print_tree(tree_map * tree) {
  if (tree->root != NULL) print_tree_entry(tree->root);
}

int * entry_find(entry_t * entry, char * key) {
  if (entry == NULL) return NULL;
  int res = strcmp(key, entry->key);
  if (res == 0) {
    return &(entry->value);
  } else if (res < 0) {
    return entry_find(entry->left, key);
  } else return entry_find(entry->right, key);
}

int * find(tree_map * tree, char * key) {
  return entry_find(tree->root, key);
}

int main(int argc, char const *argv[]) {
  tree_map * map = new_tree_map();
  char str1[] = "hej";
  char str2[] = "hej2";
  update(map, str1, 3);
  update(map, str2, 6);
  update(map, str2, 12);

  print_tree(map);
  return 0;
}
