/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package mozilla.lockbox.extensions

import mozilla.appservices.logins.ServerPassword
import mozilla.lockbox.model.ItemDetailViewModel
import mozilla.lockbox.model.ItemViewModel

fun ServerPassword.toViewModel(): ItemViewModel {
    val username = this.username ?: ""
    val hostname = titleFromHostname(this.hostname)
    return ItemViewModel(hostname, username, this.id)
}

fun ServerPassword.toDetailViewModel(): ItemDetailViewModel {
    return ItemDetailViewModel(id, titleFromHostname(hostname), hostname, username, password)
}

private fun titleFromHostname(hostname: String): String {
    return hostname
            .replace(Regex("^http://"), "")
            .replace(Regex("^https://"), "")
            .replace(Regex("^www\\d*\\."), "")
}