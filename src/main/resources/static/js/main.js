// ========== Global Config ==========
const BASIC_AUTH = 'Basic ' + btoa('admin:admin123');

// ========== Helper: Auth Header ==========
function authHeaders() {
    return {
        'Authorization': BASIC_AUTH
    };
}

// ========== Helper: JSON Headers with Auth ==========
function jsonAuthHeaders() {
    return {
        'Content-Type': 'application/json',
        'Authorization': BASIC_AUTH
    };
}

// ========== Helper: Show Success Message ==========
function showSuccess(msg) {
    alert("✅ " + msg);
}

// ========== Helper: Show Error Message ==========
function showError(msg) {
    alert("❌ Error: " + msg);
}

// ========== Reusable Fetch Wrapper (Optional) ==========
async function apiGet(url) {
    const res = await fetch(url, { headers: authHeaders() });
    if (!res.ok) throw new Error(`GET failed: ${res.status}`);
    return await res.json();
}

async function apiPost(url, data) {
    const res = await fetch(url, {
        method: "POST",
        headers: jsonAuthHeaders(),
        body: JSON.stringify(data)
    });
    if (!res.ok) throw new Error(`POST failed: ${res.status}`);
    return await res.json();
}
