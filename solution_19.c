/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    int sz = 0;
    struct ListNode *c = head;
    while (c != NULL) {
        if (c->val < 0 || c->val > 100)
            return head;
        sz++;
        c = c->next;
    }
    if (sz < 1 || sz > 30)
        return head;
    if (n < 1 || n > sz)
        return head;
    struct ListNode *cur = head;
    int index = 0;
    struct ListNode *next = head;
    if (sz == 1 && n == 1) {
        head = NULL;
        return head;
    }
    if (sz - n == 0) {
        head = head->next;
        return head;
    }
    while (cur != NULL && index != sz - n) {
        cur = next;
        next = cur->next;
        index++;
    }
    cur->next = next->next;
    return head;
}