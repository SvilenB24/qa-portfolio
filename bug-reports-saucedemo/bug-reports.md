# Bug Reports — SauceDemo (Swag Labs)

**Application under test:** https://www.saucedemo.com
**Test approach:** Exploratory testing — baseline established with `standard_user`,
then defects hunted with `problem_user`, comparing against the expected baseline.
**Password (all users):** `secret_sauce`

---

## [BUG-01] - Checkout - Cart - Empty Cart Validation - Order can be completed with an empty cart ($0 order)

**Precondition:** User is logged in as "standard_user" and is on the inventory page
(https://www.saucedemo.com/inventory.html). The cart is empty.

**Steps to Reproduce:**
1. Click the cart icon in the top-right corner
2. Confirm the cart is empty (no items listed)
3. Click the "Checkout" button
4. Enter First Name: "Ivan"
5. Enter Last Name: "Ivanov"
6. Enter Zip/Postal Code: "1111"
7. Click "Continue"
8. Click "Finish"

**Actual Result:** The user is redirected to /checkout-complete.html and receives the
confirmation "Thank you for your order!" — an empty, $0 order is completed.

**Expected Result:** The system should prevent empty-cart checkout — e.g. the "Checkout"
button is disabled when the cart is empty, or an error ("Your cart is empty") is shown,
and the order is NOT completed.

**Severity:** Medium — the system does not crash, no data is lost, and the core checkout
flow works. The defect is a missing validation rule that allows an invalid state.

**Priority:** High — empty $0 orders pollute the order/accounting system and create
meaningless work for the business, so it should be fixed quickly.

**Environment:** Chrome 148 / Windows 10 / user: standard_user

---

## [BUG-02] - Checkout - Customer Information - Last Name field - Input is redirected to First Name, blocking checkout

**Precondition:** User is logged in as "problem_user" and is on the inventory page.

**Steps to Reproduce:**
1. Add a product whose "Add to cart" button works (e.g. "Sauce Labs Backpack")
2. Click the cart icon in the top-right corner
3. Confirm the product is listed in the cart
4. Click "Checkout"
5. Enter First Name: "Ivan"
6. Attempt to enter Last Name: "Ivanov"
7. Observe the field behavior

**Actual Result:** The "Last Name" field does not accept input. Characters typed into
"Last Name" appear in the "First Name" field instead. Additionally, only a single
character is retained — each new character replaces the previous one. As a result the
required "Last Name" cannot be filled and "Continue" cannot be completed → checkout is blocked.

**Expected Result:** The user can fill "First Name", "Last Name" and "Zip/Postal Code"
independently and proceed via "Continue" to complete the order.

**Severity:** High — a core function (purchasing) is completely broken with no workaround
for the affected user; the order cannot be placed.

**Priority:** High — checkout/revenue is blocked, so it must be fixed as soon as possible.

**Environment:** Chrome 148 / Windows 10 / user: problem_user

---

## [BUG-03] - Inventory - Product Image - All product thumbnails - Every product shows the same placeholder image

**Precondition:** User is logged in as "problem_user" and is on the inventory page.

**Steps to Reproduce:**
1. Observe the product images on the inventory page

**Actual Result:** All 6 products display the same image (a dog holding a ball / "404"
placeholder) instead of their own product photo. Affected products:
- Sauce Labs Backpack
- Sauce Labs Bike Light
- Sauce Labs Bolt T-Shirt
- Sauce Labs Fleece Jacket
- Sauce Labs Onesie
- Test.allTheThings() T-Shirt (Red)

**Expected Result:** Each product displays its own correct product image, matching the
images shown for "standard_user".

**Severity:** Low — purely visual; nothing crashes, no data is lost, and the user can
still browse and purchase.

**Priority:** High — the customer cannot see what the product actually looks like before
buying, which damages trust and can reduce conversions across the entire catalogue.

**Environment:** Chrome 148 / Windows 10 / user: problem_user

---

## [BUG-04] - Inventory - Add to Cart - Multiple products - "Add to cart" button does nothing for 3 products

**Precondition:** User is logged in as "problem_user" and is on the inventory page.

**Steps to Reproduce:**
1. Click "Add to cart" on "Sauce Labs Bolt T-Shirt"
2. Repeat for "Sauce Labs Fleece Jacket" and "Test.allTheThings() T-Shirt (Red)"
3. Observe the cart badge

**Actual Result:** The button does not respond; the product is not added to the cart and
the cart badge does not increase for these 3 products. (Other products add normally.)

**Expected Result:** Clicking "Add to cart" adds the product to the cart and the cart
badge increments, as it does for "standard_user".

**Severity:** High — purchasing is fully blocked for these products, with no workaround.

**Priority:** High — directly prevents sales of the affected items.

**Environment:** Chrome 148 / Windows 10 / user: problem_user

---

## [BUG-05] - Inventory - Sorting - Sort dropdown - Sorting has no effect on product order

**Precondition:** User is logged in as "problem_user" and is on the inventory page.

**Steps to Reproduce:**
1. Open the sort dropdown (top-right)
2. Select each option in turn: "Name (Z to A)", "Price (low to high)", "Price (high to low)"
3. Observe the product order after each selection

**Actual Result:** The product order does not change for any sort option.

**Expected Result:** The product list re-orders according to the selected option, as it
does for "standard_user".

**Severity:** Medium — a feature is broken, but the user can still browse and buy
(workaround: scroll manually); nothing crashes.

**Priority:** Medium — sorting is a convenience that aids product discovery.

**Environment:** Chrome 148 / Windows 10 / user: problem_user

---

## [BUG-06] - Inventory - Remove Item - "Remove" button on listing - Item cannot be removed from the inventory page

**Precondition:** User is logged in as "problem_user" with at least one item in the cart,
on the inventory page.

**Steps to Reproduce:**
1. Add a product to the cart
2. On the inventory page, click "Remove" on that product
3. Observe the cart badge

**Actual Result:** On the inventory page the "Remove" button does not respond; the item
stays in the cart and the badge does not decrease. (Removing the same item from the Cart
page works — this is a workaround.)

**Expected Result:** Clicking "Remove" on the inventory page removes the item and the cart
badge decreases.

**Severity:** Medium — a feature is broken, but a workaround exists (remove from the Cart page).

**Priority:** High — affects normal cart management on the main shopping screen.

**Environment:** Chrome 148 / Windows 10 / user: problem_user

---

## [BUG-07] - Session - Cart Persistence - Cross-account - Cart contents leak between different user accounts

**Precondition:** Two accounts available (e.g. "standard_user" and "problem_user") in the
same browser.

**Steps to Reproduce:**
1. Log in as "standard_user" and add one or more items to the cart
2. Open the menu and click "Logout"
3. Log in as "problem_user"
4. Open the cart

**Actual Result:** The items added by "standard_user" are still in the cart under
"problem_user". The same happens with removals — cart state carries over between accounts.

**Expected Result:** Each user account has its own independent cart; logging into a
different account shows that account's own (empty) cart.

**Severity:** High — this is a data-integrity / privacy defect, not a cosmetic one: one
account's cart data appears under another account. Data must not leak between users.

**Priority:** High (arguably Critical) — a previous user's cart can be seen, and the
current user may unknowingly order items they did not add, causing wrong orders and a
privacy concern.

**Environment:** Chrome 148 / Windows 10
